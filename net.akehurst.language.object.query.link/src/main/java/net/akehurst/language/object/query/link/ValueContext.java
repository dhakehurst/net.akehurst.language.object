package net.akehurst.language.object.query.link;

public interface ValueContext {

	Object getStringLiteral(String symbol);
	Object getBooleanLiteral(String symbol);
	Object getNumberLiteral(String symbol);
	Object getObject(Object object);
	
	Object getProperty(Object object, String propertyName, Object...qualifiers);
	
	Object getOperation(Object object, String propertyName, Object...arguments);
}
