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

package com.autodetservice.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AutoDetails. This utility wraps
 * {@link com.autodetservice.service.impl.AutoDetailsLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AutoDetailsLocalService
 * @see com.autodetservice.service.base.AutoDetailsLocalServiceBaseImpl
 * @see com.autodetservice.service.impl.AutoDetailsLocalServiceImpl
 * @generated
 */
@ProviderType
public class AutoDetailsLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.autodetservice.service.impl.AutoDetailsLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the auto details to the database. Also notifies the appropriate model listeners.
	*
	* @param autoDetails the auto details
	* @return the auto details that was added
	*/
	public static com.autodetservice.model.AutoDetails addAutoDetails(
		com.autodetservice.model.AutoDetails autoDetails) {
		return getService().addAutoDetails(autoDetails);
	}

	/**
	* Creates a new auto details with the primary key. Does not add the auto details to the database.
	*
	* @param autodetailId the primary key for the new auto details
	* @return the new auto details
	*/
	public static com.autodetservice.model.AutoDetails createAutoDetails(
		long autodetailId) {
		return getService().createAutoDetails(autodetailId);
	}

	/**
	* Deletes the auto details from the database. Also notifies the appropriate model listeners.
	*
	* @param autoDetails the auto details
	* @return the auto details that was removed
	*/
	public static com.autodetservice.model.AutoDetails deleteAutoDetails(
		com.autodetservice.model.AutoDetails autoDetails) {
		return getService().deleteAutoDetails(autoDetails);
	}

	/**
	* Deletes the auto details with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details that was removed
	* @throws PortalException if a auto details with the primary key could not be found
	*/
	public static com.autodetservice.model.AutoDetails deleteAutoDetails(
		long autodetailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteAutoDetails(autodetailId);
	}

	public static com.autodetservice.model.AutoDetails fetchAutoDetails(
		long autodetailId) {
		return getService().fetchAutoDetails(autodetailId);
	}

	/**
	* Returns the auto details matching the UUID and group.
	*
	* @param uuid the auto details's UUID
	* @param groupId the primary key of the group
	* @return the matching auto details, or <code>null</code> if a matching auto details could not be found
	*/
	public static com.autodetservice.model.AutoDetails fetchAutoDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchAutoDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the auto details with the primary key.
	*
	* @param autodetailId the primary key of the auto details
	* @return the auto details
	* @throws PortalException if a auto details with the primary key could not be found
	*/
	public static com.autodetservice.model.AutoDetails getAutoDetails(
		long autodetailId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAutoDetails(autodetailId);
	}

	/**
	* Returns the auto details matching the UUID and group.
	*
	* @param uuid the auto details's UUID
	* @param groupId the primary key of the group
	* @return the matching auto details
	* @throws PortalException if a matching auto details could not be found
	*/
	public static com.autodetservice.model.AutoDetails getAutoDetailsByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getAutoDetailsByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the auto details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param autoDetails the auto details
	* @return the auto details that was updated
	*/
	public static com.autodetservice.model.AutoDetails updateAutoDetails(
		com.autodetservice.model.AutoDetails autoDetails) {
		return getService().updateAutoDetails(autoDetails);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of auto detailses.
	*
	* @return the number of auto detailses
	*/
	public static int getAutoDetailsesCount() {
		return getService().getAutoDetailsesCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.autodetservice.model.impl.AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.autodetservice.model.impl.AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> findAll() {
		return getService().findAll();
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> findSomething(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.autodetservice.model.AutoDetails> orderByComparator) {
		return getService().findSomething(start, end, orderByComparator);
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> findSomething(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.autodetservice.model.AutoDetails> orderByComparator,
		boolean retrieveFromCache) {
		return getService()
				   .findSomething(start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns a range of all the auto detailses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.autodetservice.model.impl.AutoDetailsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of auto detailses
	* @param end the upper bound of the range of auto detailses (not inclusive)
	* @return the range of auto detailses
	*/
	public static java.util.List<com.autodetservice.model.AutoDetails> getAutoDetailses(
		int start, int end) {
		return getService().getAutoDetailses(start, end);
	}

	/**
	* Returns all the auto detailses matching the UUID and company.
	*
	* @param uuid the UUID of the auto detailses
	* @param companyId the primary key of the company
	* @return the matching auto detailses, or an empty list if no matches were found
	*/
	public static java.util.List<com.autodetservice.model.AutoDetails> getAutoDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getAutoDetailsesByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of auto detailses matching the UUID and company.
	*
	* @param uuid the UUID of the auto detailses
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of auto detailses
	* @param end the upper bound of the range of auto detailses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching auto detailses, or an empty list if no matches were found
	*/
	public static java.util.List<com.autodetservice.model.AutoDetails> getAutoDetailsesByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.autodetservice.model.AutoDetails> orderByComparator) {
		return getService()
				   .getAutoDetailsesByUuidAndCompanyId(uuid, companyId, start,
			end, orderByComparator);
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> getBY_U(
		long userId, int year) {
		return getService().getBY_U(userId, year);
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> getByM_U(
		long userId, java.lang.String model) {
		return getService().getByM_U(userId, model);
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> getEntries(
		long userId, java.lang.String model, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<com.autodetservice.model.AutoDetails> obc) {
		return getService().getEntries(userId, model, start, end, obc);
	}

	public static java.util.List<com.autodetservice.model.AutoDetails> lastFind(
		int start, int end) {
		return getService().lastFind(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static AutoDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<AutoDetailsLocalService, AutoDetailsLocalService> _serviceTracker =
		ServiceTrackerFactory.open(AutoDetailsLocalService.class);
}