/*******************************************************************************
 * Copyright (c) 2014 Red Hat, Inc.
 * Distributed under license by Red Hat, Inc. All rights reserved.
 * This program is made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat, Inc. - initial API and implementation
 ******************************************************************************/
package org.jboss.tools.openshift.express.internal.ui.wizard.embed;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jboss.tools.common.databinding.ObservablePojo;
import org.jboss.tools.openshift.express.internal.core.IApplicationProperties;
import org.jboss.tools.openshift.express.internal.core.connection.Connection;

import com.openshift.client.ApplicationScale;
import com.openshift.client.IDomain;
import com.openshift.client.cartridge.ICartridge;

/**
 * @author Andre Dietisheim
 */
public class EmbeddedCartridgesWizardModel extends ObservablePojo {

	private Set<ICartridge> embeddedCartridges;
	private List<ICartridge> availableCartridges;
	private Connection connection;
	private IDomain domain;
	private IApplicationProperties applicationProperties;

	public EmbeddedCartridgesWizardModel(Set<ICartridge> embeddedCartrdiges, List<ICartridge> availableCartridges, 
			IApplicationProperties applicationProperties, IDomain domain, Connection connection) {
		this.embeddedCartridges = new HashSet<ICartridge>();
		this.embeddedCartridges.addAll(embeddedCartrdiges);
		this.availableCartridges = availableCartridges;
		this.applicationProperties = applicationProperties;
		this.domain = domain;
		this.connection = connection;
	}

	public List<ICartridge> getEmbeddableCartridges() {
		return availableCartridges;
	}
	
	public Set<ICartridge> getEmbeddedCartridges() {
		return embeddedCartridges;
	}

	public boolean isEmbedded(ICartridge cartridge) {
		return embeddedCartridges.contains(cartridge);
	}
	
	public Set<ICartridge> setCheckedEmbeddableCartridges(Set<ICartridge> cartridges) {
		return	this.embeddedCartridges = cartridges;
	}

	public Set<ICartridge> getCheckedEmbeddableCartridges() {
		return embeddedCartridges;
	}

	public void refresh() {
	}

	public ApplicationScale getApplicationScale() {
		return applicationProperties.getApplicationScale();
	}

	public ICartridge getStandaloneCartridge() {
		return applicationProperties.getStandaloneCartridge();
	}

	public String getApplicationName() {
		return applicationProperties.getApplicationName();
	}
	
	public Connection getConnection() {
		return connection;
	}

	public IDomain getDomain() {
		return domain;
	}
}