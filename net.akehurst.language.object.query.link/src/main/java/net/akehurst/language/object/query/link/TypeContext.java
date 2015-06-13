package net.akehurst.language.object.query.link;

import net.akehurst.language.object.type.Operation;
import net.akehurst.language.object.type.Property;
import net.akehurst.language.object.type.Type;

public interface TypeContext {

	Type getStringLiteral();
	Type getBooleanLiteral();
	Type getNumberLiteral();
	Type getFor(Object object);
	
	Property getProperty(Type type, String propertyName, Type...qualifierTypes);
	
	Operation getOperation(Type type, String propertyName, Type...typeArguments);
	
}
