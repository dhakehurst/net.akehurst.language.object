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

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EStructuralFeature;

import net.akehurst.language.object.query.link.ObjectQueryLinkException;
import net.akehurst.language.object.query.link.TypeContext;
import net.akehurst.language.object.type.Type;
import net.akehurst.language.object.type.Property;

public class PropertyForEcore implements Property {

	public PropertyForEcore(TypeContext context, EStructuralFeature structuralFeature) {
		this.context = context;
		this.structuralFeature = structuralFeature;
	}
	
	TypeContext context;
	EStructuralFeature structuralFeature;

	Type type_cache = null;
	public Type getType() {
		if (this.type_cache == null) {
			EClassifier eType = this.structuralFeature.getEType();
			Type type = this.context.getFor(eType);
			if (this.structuralFeature.isMany()) {
				if (this.structuralFeature.isUnique()) {
					this.type_cache = this.context.getOrderedSetType(type);
				} else {
					this.type_cache = this.context.getSequenceType(type);
				}
			} else {
				this.type_cache = type;
			}
		}
		return this.type_cache;
	}

	public String getName() {
		if (null == this.structuralFeature) {
			throw new RuntimeException("structurealFeature is null");
		} else {
			return this.structuralFeature.getName();
		}
	}

}
