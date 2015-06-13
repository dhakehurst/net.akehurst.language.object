/*
 * Copyright (c) 2015 D. David H. Akehurst
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the
 * License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
package net.akehurst.language.object.query.link.ecore;

import java.util.ArrayList;
import java.util.List;

import net.akehurst.language.object.query.link.TypeContext;
import net.akehurst.language.object.type.Operation;
import net.akehurst.language.object.type.Property;
import net.akehurst.language.object.type.Type;

public class TypeForEcore implements Type {

	public TypeForEcore(TypeContext context, EClassifier eClassifier) {
		this.context = context;
		this.eClassifier = eClassifier;
	}

	TypeContext context;
	EClassifier eClassifier;

	List<Type> typeArguments_cache;

	public List<Type> getTypeArguments() {
		if (null == typeArguments_cache) {
			this.typeArguments_cache = new ArrayList<>();
			for (ETypeParameter tp : eClassifier.getETypeParameters()) {
				EClassifier ec = tp.getEBounds().get(0).getEClassifier();
				Type ta = this.context.getFor(ec);
				this.typeArguments_cache.add(ta);
			}
		}
		return this.typeArguments_cache;
	}

	public List<Type> getSuperTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Type> getAllSuperTypes() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Property> getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Property> getAllProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public Property getProperty(String name, Type... qualifierTypes) {
		if (this.eClassifier instanceof EClass) {
			EClass cls = (EClass) this.eClassifier;
			EStructuralFeature fe = cls.getEStructuralFeature(name);
			return new PropertyForEcore(this.context, fe);
		}
		return null;
	}

	public List<Operation> getOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Operation> getAllOperations() {
		// TODO Auto-generated method stub
		return null;
	}

	public Operation getOperation(String name, Type... arguments) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean conformsTo(Type otherType) {
		// TODO Auto-generated method stub
		return null;
	}

}
