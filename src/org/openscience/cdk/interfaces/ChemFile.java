/* $RCSfile$
 * $Author$
 * $Date$
 * $Revision$
 *
 * Copyright (C) 1997-2005  The Chemistry Development Kit (CDK) project
 *
 * Contact: cdk-devel@lists.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package org.openscience.cdk.interfaces;

/**
 * A Object containing a number of ChemSequences. This is supposed to be the
 * top level container, which can contain all the concepts stored in a chemical
 * document
 *
 * @author     egonw
 * @cdk.module data
 */
public interface ChemFile extends ChemObject {

	/**
	 * Adds an ChemSequence to this container.
	 *
	 * @param  chemSequence  The chemSequence to be added to this container
	 * @see                  #getChemSequences
	 */
	public void addChemSequence(ChemSequence chemSequence);

	/**
	 * Returns the array of ChemSequences of this container.
	 *
	 * @return    The array of ChemSequences of this container
	 * @see       #addChemSequence
	 */
	public org.openscience.cdk.ChemSequence[] getChemSequences();

	/**
	 * Returns the ChemSequence at position <code>number</code> in the container.
	 *
	 * @param  number  The position of the ChemSequence to be returned.
	 * @return         The ChemSequence at position <code>number</code>.
	 * @see            #addChemSequence
	 */
	public org.openscience.cdk.ChemSequence getChemSequence(int number);

	/**
	 * Returns the number of ChemSequences in this Container.
	 *
	 * @return    The number of ChemSequences in this Container
	 */
	public int getChemSequenceCount();

}

