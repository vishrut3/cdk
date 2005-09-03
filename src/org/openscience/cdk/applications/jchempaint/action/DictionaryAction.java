/* $RCSfile$    
 * $Author$    
 * $Date$    
 * $Revision$
 *
 * Copyright (C) 2003-2005  The JChemPaint project
 *
 * Contact: jchempaint-devel@lists.sourceforge.net
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License
 * as published by the Free Software Foundation; either version 2.1
 * of the License, or (at your option) any later version.
 * All we ask is that proper credit is given for our work, which includes
 * - but is not limited to - adding the above copyright notice to the beginning
 * of your source code files, and to any copyright notice that you may distribute
 * with programs based on this work.
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
package org.openscience.cdk.applications.jchempaint.action;

import java.awt.event.ActionEvent;

import org.openscience.cdk.Atom;
import org.openscience.cdk.interfaces.AtomContainer;
import org.openscience.cdk.Bond;
import org.openscience.cdk.ChemModel;
import org.openscience.cdk.applications.jchempaint.JChemPaintModel;
import org.openscience.cdk.dict.CDKDictionaryReferences;
import org.openscience.cdk.tools.manipulator.ChemModelManipulator;


/**
 * Creates a dictionary entry for a selected entity
 *
 * @cdk.module jchempaint
 * @author  Egon Willighagen
 * @cdk.created 2003-08-08
 */
public class DictionaryAction extends JCPAction {

    public void actionPerformed(ActionEvent event) {
        logger.debug("Dictionary Action triggered");
        JChemPaintModel jcpModel = jcpPanel.getJChemPaintModel();
        ChemModel chemModel = jcpModel.getChemModel();
        
        // make explicit references
        CDKDictionaryReferences.makeReferencesExplicit(chemModel);
        AtomContainer container = ChemModelManipulator.getAllInOneContainer(chemModel);
        org.openscience.cdk.interfaces.Atom[] atoms = container.getAtoms();
        for (int i=0; i<atoms.length; i++) {
            logger.debug("Making references for atom...");
            CDKDictionaryReferences.makeReferencesExplicit(atoms[i]);
        }
        Bond[] bonds = container.getBonds();
        for (int i=0; i<bonds.length; i++) {
            logger.debug("Making references for bond...");
            CDKDictionaryReferences.makeReferencesExplicit(bonds[i]);
        }
        
        jcpModel.fireChange();
    }
    
}
