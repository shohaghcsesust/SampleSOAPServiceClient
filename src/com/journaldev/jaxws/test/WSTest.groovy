package com.journaldev.jaxws.test

import com.journaldev.jaxws.beans.Person
import com.journaldev.jaxws.service.PersonServiceImpl
import com.journaldev.jaxws.service.PersonServiceImplServiceLocator
import com.journaldev.jaxws.service.PersonServiceImplSoapBindingStub

class WSTest {

	static main(args) {
		WSTest test = new WSTest();
		test.init()
		test.testAddPerson()
		test.testGetAllPersons()
	}
	
	private PersonServiceImplSoapBindingStub soapManager
	
	def init(){
		soapManager = new PersonServiceImplSoapBindingStub()
		soapManager.cachedEndpoint = new URL(new PersonServiceImplServiceLocator().getPersonServiceImplAddress())
	}
	
	//test web service
	def testAddPerson(){
		Person p = new Person();
		p.name = 'Saif'
		p.age = 30;
		p.id = 105;
		
		def isAdded = soapManager.addPerson(p)
		println isAdded
	}
	
	def testGetAllPersons(){
		Person[] person = soapManager.getAllPersons()
		for(Person p : person){
			println p.getId()+' '+p.getName()+' '+p.getAge()
		}
	}
}
