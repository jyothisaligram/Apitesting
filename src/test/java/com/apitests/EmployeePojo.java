package com.apitests;

import java.io.File;

public class EmployeePojo {
	       private int id;
	       private String EmpName;
	       private int salary;
	       private int age;
	      
		
	      /**
		 * @return the profile_image
	



		/**
		 * @param profile_image the profile_image to set
		 */
		




		public EmployeePojo() {
	      }
	           
	       
	       
	       
	  public EmployeePojo(String EmpName, int salary, int age, int id) {
		  this.id = id;
		  this.EmpName = EmpName;
		  this.salary = salary;
		  this.age = age;
		 
	  }
	       
		       
	       /**
		 * @return the empName
		 */
		public String getEmpName() {
			return EmpName;
		}
		/**
		 * @param empName the empName to set
		 */
		public void setEmpName(String empName) {
			EmpName = empName;
		}
		/**
		 * @return the salary
		 */
		public int getSalary() {
			return salary;
		}
		/**
		 * @param salary the salary to set
		 */
		public void setSalary(int salary) {
			this.salary = salary;
		}
		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}
		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		/**
		 * @return the id
		 */
		public int getId() {
			return id;
		}
		/**
		 * @param id the id to set
		 */
		public void setId(int id) {
			this.id = id;
		}
		
		public String toString() {
			return "\nName = "+this.EmpName+ "\nAge = "+this.age +"\nsalary = "
		+ this.salary +"\nid ="+this.id;
		}
		
}
