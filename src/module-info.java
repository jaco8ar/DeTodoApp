/**
 * 
 */
/**
 * @author Lenovo
 *
 */
module DeTodoApp {
	requires java.sql;
	requires jakarta.persistence;
	requires org.apache.commons.codec;
	requires java.desktop;
	requires spring.core;
	requires spring.boot;
	requires spring.boot.autoconfigure;
	
	
	opens main.java.classes to spring.core, spring.beans, spring.context;
	
}