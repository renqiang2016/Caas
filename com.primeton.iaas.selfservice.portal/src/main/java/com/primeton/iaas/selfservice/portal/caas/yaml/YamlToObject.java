/**
 * 
 */
package com.primeton.iaas.selfservice.portal.caas.yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import io.fabric8.kubernetes.api.model.ReplicationController;

/**
 * @author RenQiang
 *
 */
public class YamlToObject {
	public static ReplicationController getReplicationController(File file) {
		Yaml yaml = new Yaml(new Constructor(ReplicationController.class));
		ReplicationController replicationController = null;
		try {
			replicationController = (ReplicationController) yaml.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return replicationController;
	}
	
	public static void main(String[] args) {
		File file = new File("RC.yaml");
		if(file.isFile() && file.exists()){
			System.out.println(getReplicationController(file).toString());
		}else {
			System.out.println("找不到指定文件！");
		}
		
	}
}
