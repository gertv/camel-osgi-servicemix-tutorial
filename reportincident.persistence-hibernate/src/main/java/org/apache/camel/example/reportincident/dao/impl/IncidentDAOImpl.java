/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.reportincident.dao.impl;


import java.util.List;

import org.apache.camel.example.reportincident.dao.IncidentDAO;
import org.apache.camel.example.reportincident.model.Incident;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.impl.SessionImpl;


public class IncidentDAOImpl implements IncidentDAO
{

	private static final transient Log LOG = LogFactory.getLog(IncidentDAOImpl.class);
	
    /** The session factory. */
    private SessionFactory sessionFactory;

    /** The q. */
    private Query q = null;

    /** The Constant findIncidentByReference. */
    private final static String findIncidentByReference =
        "select i from Incident as i where i.incidentRef = :ref";

    /** The Constant findIncident. */
    private final static String findIncident =
        "select i from Incident as i";
    
    /**
     * Sets the session factory.
     * 
     * @param sessionFactory the new session factory
     */
    public void setSessionFactory( SessionFactory sessionFactory )
    {
        this.sessionFactory = sessionFactory;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.camel.example.reportincident.dao.IncidentDAO#findIncident()
     */
    public List<Incident> findIncident()
        throws HibernateException
    {

        // Prepare query
        q = this.sessionFactory.getCurrentSession().createQuery( findIncident );

        // Retrieve the Incidents from database
        List<Incident> list = q.list();

        return list;

    }

    /*
     * (non-Javadoc)
     * @see org.apache.camel.example.reportincident.dao.IncidentDAO#findIncident(java.lang.String)
     */
    public List<Incident> findIncident( String key )
        throws HibernateException
    {
        q = this.sessionFactory.getCurrentSession().createQuery( findIncidentByReference );
        q.setString("ref", key );
        List<Incident> list = q.list();

        return list;
    }

    /*
     * (non-Javadoc)
     * @see org.apache.camel.example.reportincident.dao.IncidentDAO#getIncident(long)
     */
    public Incident getIncident( long id )
    {
        return (Incident) this.sessionFactory.getCurrentSession().get( Incident.class, id );
    }

    /*
     * (non-Javadoc)
     * @see org.apache.camel.example.reportincident.dao.IncidentDAO#removeIncident(long)
     */
    public void removeIncident( long id )
    {
        Object record = this.sessionFactory.getCurrentSession().load( Incident.class, id );
        this.sessionFactory.getCurrentSession().delete( record );

    }

    /*
     * (non-Javadoc)
     * @see org.apache.camel.example.reportincident.dao.IncidentDAO#saveIncident(org.apache.camel.example.reportincident.model.Incident)
     */
    public void saveIncident( Incident Incident )
    {
    	SessionImpl session = (SessionImpl) this.sessionFactory.getCurrentSession();
        this.sessionFactory.getCurrentSession().saveOrUpdate( Incident );
    }

}
