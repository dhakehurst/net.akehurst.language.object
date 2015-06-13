/*
 * Copyright (c) 2015 D. David H. Akehurst
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.akehurst.language.object.query.link.ecore;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.util.EcoreUtil;

import net.akehurst.language.object.query.link.TypeContext;
import net.akehurst.language.object.type.Operation;
import net.akehurst.language.object.type.Property;
import net.akehurst.language.object.type.Type;

public class TypeContextForEcore implements TypeContext {

	public TypeContextForEcore() {
		this.ecore = EcorePackage.eINSTANCE;
		this.rootObjects = new HashMap<>();
	}
	
	EcorePackage ecore;
	Map<String, Type> rootObjects;
	
	Type createType(EClassifier eClassifier) {
		TypeForEcore type = new TypeForEcore(this, eClassifier);
		return type;
	}
	
	public Type getStringLiteral() {
		return this.createType(ecore.getEString());
	}

	public Type getBooleanLiteral() {
		return this.createType(ecore.getEBoolean());
	}

	public Type getNumberLiteral() {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getFor(Object object) {
		if (object instanceof EClassifier) {
			EClassifier eClassifier = (EClassifier)object;
			return this.createType(eClassifier);
		} else if (object instanceof EObject) {
			EObject eObj = (EObject)object;
			return this.createType(eObj.eClass());
		} else {
			throw new RuntimeException("Cannot create type for "+object);
		}
	}

	public Property getProperty(Type type, String propertyName, Type... qualifierTypes) {
		return type.getProperty(propertyName, qualifierTypes);
	}

	public Operation getOperation(Type type, String propertyName, Type... parameterTypes) {
		return type.getOperation(propertyName, parameterTypes);
	}

	public Type getOrderedSetType(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Type getSequenceType(Type type) {
		TypeForEcore tfe = (TypeForEcore)type;
		EGenericType gt = ecore.getEcoreFactory().createEGenericType();
		gt.setEClassifier( ecore.getEEList() );
		gt.getETypeArguments().get(0).setEClassifier(tfe.eClassifier);
		ecore.getEClass().
		return this.createType(gt.getEClassifier());
	}

}
