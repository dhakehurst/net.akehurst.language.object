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
package net.akehurst.language.object.query.link;

import net.akehurst.language.object.type.Operation;
import net.akehurst.language.object.type.Property;
import net.akehurst.language.object.type.Type;

public interface TypeContext {

	Type getFor(Object object);

	Type getStringLiteral();
	Type getBooleanLiteral();
	Type getNumberLiteral();

	Type getOrderedSetType(Type type);
	Type getSequenceType(Type type);
	
	Property getProperty(Type type, String propertyName, Type...qualifierTypes);
	
	Operation getOperation(Type type, String propertyName, Type...typeArguments);
	
}
