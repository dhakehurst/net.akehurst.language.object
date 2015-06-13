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
