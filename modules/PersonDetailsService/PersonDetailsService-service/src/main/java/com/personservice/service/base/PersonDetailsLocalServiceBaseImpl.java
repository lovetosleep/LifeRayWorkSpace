/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.personservice.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import com.personservice.model.PersonDetails;

import com.personservice.service.PersonDetailsLocalService;
import com.personservice.service.persistence.PersonDetailsPersistence;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the person details local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.personservice.service.impl.PersonDetailsLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.personservice.service.impl.PersonDetailsLocalServiceImpl
 * @see com.personservice.service.PersonDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
public abstract class PersonDetailsLocalServiceBaseImpl
	extends BaseLocalServiceImpl implements PersonDetailsLocalService,
		IdentifiableOSGiService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.personservice.service.PersonDetailsLocalServiceUtil} to access the person details local service.
	 */

	/**
	 * Adds the person details to the database. Also notifies the appropriate model listeners.
	 *
	 * @param personDetails the person details
	 * @return the person details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PersonDetails addPersonDetails(PersonDetails personDetails) {
		personDetails.setNew(true);

		return personDetailsPersistence.update(personDetails);
	}

	/**
	 * Creates a new person details with the primary key. Does not add the person details to the database.
	 *
	 * @param PersonDetailId the primary key for the new person details
	 * @return the new person details
	 */
	@Override
	public PersonDetails createPersonDetails(long PersonDetailId) {
		return personDetailsPersistence.create(PersonDetailId);
	}

	/**
	 * Deletes the person details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param PersonDetailId the primary key of the person details
	 * @return the person details that was removed
	 * @throws PortalException if a person details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PersonDetails deletePersonDetails(long PersonDetailId)
		throws PortalException {
		return personDetailsPersistence.remove(PersonDetailId);
	}

	/**
	 * Deletes the person details from the database. Also notifies the appropriate model listeners.
	 *
	 * @param personDetails the person details
	 * @return the person details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public PersonDetails deletePersonDetails(PersonDetails personDetails) {
		return personDetailsPersistence.remove(personDetails);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(PersonDetails.class,
			clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return personDetailsPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.personservice.model.impl.PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end) {
		return personDetailsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.personservice.model.impl.PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery, int start,
		int end, OrderByComparator<T> orderByComparator) {
		return personDetailsPersistence.findWithDynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return personDetailsPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery,
		Projection projection) {
		return personDetailsPersistence.countWithDynamicQuery(dynamicQuery,
			projection);
	}

	@Override
	public PersonDetails fetchPersonDetails(long PersonDetailId) {
		return personDetailsPersistence.fetchByPrimaryKey(PersonDetailId);
	}

	/**
	 * Returns the person details matching the UUID and group.
	 *
	 * @param uuid the person details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching person details, or <code>null</code> if a matching person details could not be found
	 */
	@Override
	public PersonDetails fetchPersonDetailsByUuidAndGroupId(String uuid,
		long groupId) {
		return personDetailsPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the person details with the primary key.
	 *
	 * @param PersonDetailId the primary key of the person details
	 * @return the person details
	 * @throws PortalException if a person details with the primary key could not be found
	 */
	@Override
	public PersonDetails getPersonDetails(long PersonDetailId)
		throws PortalException {
		return personDetailsPersistence.findByPrimaryKey(PersonDetailId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery = new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(personDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PersonDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("PersonDetailId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		IndexableActionableDynamicQuery indexableActionableDynamicQuery = new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(personDetailsLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(PersonDetails.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"PersonDetailId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {
		actionableDynamicQuery.setBaseLocalService(personDetailsLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(PersonDetails.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("PersonDetailId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {
		final ExportActionableDynamicQuery exportActionableDynamicQuery = new ExportActionableDynamicQuery() {
				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary = portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(stagedModelType,
						modelAdditionCount);

					long modelDeletionCount = ExportImportHelperUtil.getModelDeletionCount(portletDataContext,
							stagedModelType);

					manifestSummary.addModelDeletionCount(stagedModelType,
						modelDeletionCount);

					return modelAdditionCount;
				}
			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(new ActionableDynamicQuery.AddCriteriaMethod() {
				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(dynamicQuery,
						"modifiedDate");
				}
			});

		exportActionableDynamicQuery.setCompanyId(portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(new ActionableDynamicQuery.PerformActionMethod<PersonDetails>() {
				@Override
				public void performAction(PersonDetails personDetails)
					throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(portletDataContext,
						personDetails);
				}
			});
		exportActionableDynamicQuery.setStagedModelType(new StagedModelType(
				PortalUtil.getClassNameId(PersonDetails.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {
		return personDetailsLocalService.deletePersonDetails((PersonDetails)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {
		return personDetailsPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the person detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the person detailses
	 * @param companyId the primary key of the company
	 * @return the matching person detailses, or an empty list if no matches were found
	 */
	@Override
	public List<PersonDetails> getPersonDetailsesByUuidAndCompanyId(
		String uuid, long companyId) {
		return personDetailsPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of person detailses matching the UUID and company.
	 *
	 * @param uuid the UUID of the person detailses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching person detailses, or an empty list if no matches were found
	 */
	@Override
	public List<PersonDetails> getPersonDetailsesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<PersonDetails> orderByComparator) {
		return personDetailsPersistence.findByUuid_C(uuid, companyId, start,
			end, orderByComparator);
	}

	/**
	 * Returns the person details matching the UUID and group.
	 *
	 * @param uuid the person details's UUID
	 * @param groupId the primary key of the group
	 * @return the matching person details
	 * @throws PortalException if a matching person details could not be found
	 */
	@Override
	public PersonDetails getPersonDetailsByUuidAndGroupId(String uuid,
		long groupId) throws PortalException {
		return personDetailsPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the person detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.personservice.model.impl.PersonDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of person detailses
	 * @param end the upper bound of the range of person detailses (not inclusive)
	 * @return the range of person detailses
	 */
	@Override
	public List<PersonDetails> getPersonDetailses(int start, int end) {
		return personDetailsPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of person detailses.
	 *
	 * @return the number of person detailses
	 */
	@Override
	public int getPersonDetailsesCount() {
		return personDetailsPersistence.countAll();
	}

	/**
	 * Updates the person details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param personDetails the person details
	 * @return the person details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public PersonDetails updatePersonDetails(PersonDetails personDetails) {
		return personDetailsPersistence.update(personDetails);
	}

	/**
	 * Returns the person details local service.
	 *
	 * @return the person details local service
	 */
	public PersonDetailsLocalService getPersonDetailsLocalService() {
		return personDetailsLocalService;
	}

	/**
	 * Sets the person details local service.
	 *
	 * @param personDetailsLocalService the person details local service
	 */
	public void setPersonDetailsLocalService(
		PersonDetailsLocalService personDetailsLocalService) {
		this.personDetailsLocalService = personDetailsLocalService;
	}

	/**
	 * Returns the person details persistence.
	 *
	 * @return the person details persistence
	 */
	public PersonDetailsPersistence getPersonDetailsPersistence() {
		return personDetailsPersistence;
	}

	/**
	 * Sets the person details persistence.
	 *
	 * @param personDetailsPersistence the person details persistence
	 */
	public void setPersonDetailsPersistence(
		PersonDetailsPersistence personDetailsPersistence) {
		this.personDetailsPersistence = personDetailsPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService getClassNameLocalService() {
		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService) {
		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {
		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register("com.personservice.model.PersonDetails",
			personDetailsLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"com.personservice.model.PersonDetails");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return PersonDetailsLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return PersonDetails.class;
	}

	protected String getModelClassName() {
		return PersonDetails.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = personDetailsPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = PersonDetailsLocalService.class)
	protected PersonDetailsLocalService personDetailsLocalService;
	@BeanReference(type = PersonDetailsPersistence.class)
	protected PersonDetailsPersistence personDetailsPersistence;
	@ServiceReference(type = com.liferay.counter.kernel.service.CounterLocalService.class)
	protected com.liferay.counter.kernel.service.CounterLocalService counterLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.ClassNameLocalService.class)
	protected com.liferay.portal.kernel.service.ClassNameLocalService classNameLocalService;
	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;
	@ServiceReference(type = com.liferay.portal.kernel.service.ResourceLocalService.class)
	protected com.liferay.portal.kernel.service.ResourceLocalService resourceLocalService;
	@ServiceReference(type = com.liferay.portal.kernel.service.UserLocalService.class)
	protected com.liferay.portal.kernel.service.UserLocalService userLocalService;
	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry persistedModelLocalServiceRegistry;
}