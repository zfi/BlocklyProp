/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.parallax.server.blocklyprop.services.impl;


import com.parallax.server.blocklyprop.TableOrder;
import com.parallax.server.blocklyprop.TableSort;
import com.parallax.server.blocklyprop.db.dao.ProjectDao;
import com.parallax.server.blocklyprop.db.enums.ProjectType;
import com.parallax.server.blocklyprop.db.generated.tables.records.ProjectRecord;
import com.parallax.server.blocklyprop.security.BlocklyPropSecurityUtils;
import com.parallax.server.blocklyprop.services.ProjectService;
import com.parallax.server.blocklyprop.services.ProjectSharingService;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.persist.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.shiro.authz.UnauthorizedException;

import org.apache.http.HttpHost;
import org.elasticsearch.action.DocWriteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


/**
 *
 * @author Michel
 */


@Singleton
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private ProjectDao projectDao;
    private ProjectSharingService projectSharingService;

        
    /**
     * Application logging facility
     */
    private static final Logger LOG = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Inject
    public void setProjectDao(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }

    @Inject
    public void setProjectSharingService(ProjectSharingService projectSharingService) {
        this.projectSharingService = projectSharingService;
    }

    
    /**
     * Create a new project record
     * 
     * @param name
     * @param description
     * @param descriptionHtml
     * @param privateProject
     * @param sharedProject
     * @param type
     * @param board
     * @return 
     */
    @Override
    public ProjectRecord createProject(
            String name, String description, String descriptionHtml, 
            boolean privateProject, boolean sharedProject, ProjectType type, 
            String board) {
        
        // Calling saveProject with a null project id will force underlying code
        // to create a new project
        return saveProject(
                null, name, description, descriptionHtml, privateProject, 
                sharedProject, type, board);
    }

    /**
     * Update an existing project or create a new project.
     * 
     * If the project id is not supplied, a new project will be created.
     * Otherwise, the supplied project id will be used to update that project.
     * 
     * Note: There are no sanity checks to ensure that we are updating the
     * correct project
     * .
     * @param idProject
     * @param name
     * @param description
     * @param descriptionHtml
     * @param privateProject
     * @param sharedProject
     * @param type
     * @param board
     * @return 
     */
    @Override
    public ProjectRecord saveProject(
            Long idProject, String name, String description, 
            String descriptionHtml, boolean privateProject, 
            boolean sharedProject, ProjectType type, String board) {

        
        ProjectRecord record;
        
        // Check if project is from the current user, if not, unset idProject and create new
        if (idProject != null) {
            record = projectDao.updateProject(
                    idProject, name, description, descriptionHtml, 
                    privateProject, sharedProject);
        } else {
            record = projectDao.createProject(
                    name, description, descriptionHtml, type, board, 
                    privateProject, sharedProject);
        }
        
        if (record != null) {
            UpdateProjectSearchRecord(record);
        }
        
        return record;
    }


    
    @Override
    public ProjectRecord getProjectOwnedByThisUser(Long idProject) {
        ProjectRecord projectRecord = projectDao.getProject(idProject);
        if (projectRecord != null) {
            if (projectRecord.getIdUser().equals(BlocklyPropSecurityUtils.getCurrentUserId())) {
                return projectRecord;
            } else {
                throw new UnauthorizedException("Not the current user's project");
            }
        } else {
            return null;
        }
    }

    @Override
    public ProjectRecord getProject(Long idProject) {
        
        LOG.info("Retrieving project record #{}", idProject);
        
        // Retrieve the project record
        ProjectRecord projectRecord = projectDao.getProject(idProject);
        
        if (projectRecord != null) {
            LOG.info("Project {} found", projectRecord.getId());
    
            if (projectRecord.getShared()) {
                LOG.info("Returning community project record #{}", projectRecord.getId());
                return projectRecord;
            }else{
                if (projectRecord.getIdUser().equals(BlocklyPropSecurityUtils.getCurrentUserId())){
                LOG.info("Returning private project record #{}", projectRecord.getId());
                return projectRecord;
                } else {
                    throw new UnauthorizedException("Not the current user's project");
                }
            }
        } 
        
        // Project record is unavailable
        return null;
    }

    
    /**
     * Return a list of projects.
     * 
     * @param idUser
     * @param sort
     * @param order
     * @param limit
     * @param offset
     * @return 
     */
    @Override
    public List<ProjectRecord> getUserProjects(
            Long idUser, 
            TableSort sort, 
            TableOrder order, 
            Integer limit, 
            Integer offset) {
        
        Long idCurrentUser = BlocklyPropSecurityUtils.getCurrentUserId();

        if (idCurrentUser == null) {
            throw new UnauthorizedException();
        }
        
        if (idCurrentUser.equals(idUser)) {
            return projectDao.getUserProjects(idUser, sort, order, limit, offset);
        } else {
            throw new UnauthorizedException();
        }
    }

    
    /**
     * Obtain a list of community projects
     * 
     * @param sort
     * @param order
     * @param limit
     * @param offset
     * @return 
     */
    @Override
    public List<ProjectRecord> getSharedProjects(
            TableSort sort, 
            TableOrder order, 
            Integer limit, 
            Integer offset) {

        return projectDao.getSharedProjects(sort, order, limit, offset);
    }

    @Override
    public List<ProjectRecord> getSharedProjectsByUser(TableSort sort, TableOrder order, Integer limit, Integer offset, Long idUser) {
        return projectDao.getSharedProjectsByUser(sort, order, limit, offset, idUser);
    }

    @Override
    public int countUserProjects(Long idUser) {
        return projectDao.countUserProjects(idUser);
    }

    @Override
    public int countSharedProjects() {
        return projectDao.countSharedProjects(BlocklyPropSecurityUtils.getCurrentUserId());
    }
    
    @Override
    public int countSharedProjectsByUser(Long idUser) {
        return projectDao.countSharedProjectsByUser(idUser);
    }    

    @Override
    public ProjectRecord cloneProject(Long idProject) {
        return projectDao.cloneProject(idProject);
    }

    
    /**
     * Delete a project
     * 
     * Remove the shared project link if one exists before removing the project.
     * 
     * @param idProject
     * @return 
     */
    @Override
    public boolean deleteProject(Long idProject) {
        
        LOG.info("Deleting project {}", idProject);
        
        // Remove the project shared key if it exists.
        projectSharingService.deleteSharedProject(idProject);

        return projectDao.deleteProject(idProject);
    }

    @Override
    public ProjectRecord saveProjectCode(Long idProject, String code) {

        ProjectRecord record = projectDao.updateProjectCode(idProject, code);

        // Update the project details on the search engine
        if (record != null) {
            UpdateProjectSearchRecord(record);
        }
        
        return record;
    }

    @Override
    public ProjectRecord saveProjectCodeAs(Long idProject, String code, String newName, String newBoard) {
        return projectDao.saveProjectCodeAs(idProject, code, newName, newBoard);
    }

    
    /**
     * 
     * @param record 
     */
    private void UpdateProjectSearchRecord(ProjectRecord record) {
        
        // This is the elasticsearch index name
        String indexName = "project";
        
        // The default document type
        String indexType = "_doc";
        
        LOG.info("Opening search connection");
        RestHighLevelClient client = new RestHighLevelClient(
            RestClient.builder(
                new HttpHost("localhost", 9200, "http"),
                new HttpHost("localhost", 9201, "http")));

        try {
            LOG.info("Building content object");
            XContentBuilder builder = jsonBuilder()
                    .startObject()
                    .field("id", record.getId())
                    .field("user_id", record.getIdUser())
                    .field("private", record.getPrivate())
                    .field("shared", record.getShared())
                    .field("name", record.getName())
                    .field("description", record.getDescription())
                    .field("board", record.getBoard())
                    .field("timestamp", new Date())
                .endObject();
            
            LOG.info("Preparing index entry {}", record.getId());
            IndexRequest request = new IndexRequest(
                indexName,
                indexType,
                String.valueOf(record.getId()));
            
            request.source(builder);    

            LOG.info("writing to the search engine");
            IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);

            LOG.info("Returning from search engine update");
            
            if (indexResponse.getResult() == DocWriteResponse.Result.CREATED) {
                LOG.info("Search item created.");
            } else if (indexResponse.getResult() == DocWriteResponse.Result.UPDATED) {
                LOG.info("Search item updated.");
            }

            LOG.info("Closing search connection.");
            client.close();
        }
        catch (IOException ex) {
            LOG.error("Search IO exception.");
        }
        catch (Exception ex) {
            LOG.error("An unexpected exception has occurred. Message is: {}", ex.getMessage());
        }
        
        LOG.info("Search connection is closed.");
    }
    
    private void DeleteProjectSearchRecord(long idProject) {
        // TODO: Delete the elasticsearch record for a deleted project.
        LOG.info("Deleteing project {} from search index.", idProject);
        
    }
    
}
