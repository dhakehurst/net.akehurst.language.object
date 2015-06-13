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
package net.akehurst.language.object.type;

import java.util.List;

public interface Type {

	List<Type> getSuperTypes();
	List<Type> getAllSuperTypes();
	
	List<Property> getProperties();
	List<Property> getAllProperties();
	Property getProperty(Type... qualifierTypes);
	
	List<Operation> getOperations();
	List<Operation> getAllOperations();
	Operation getOperation(Type... arguments);
	
	Boolean conformsTo(Type otherType);
}
