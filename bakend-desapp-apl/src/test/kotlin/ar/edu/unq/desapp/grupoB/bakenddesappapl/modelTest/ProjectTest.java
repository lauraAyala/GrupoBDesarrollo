package ar.edu.unq.desapp.grupoB.bakenddesappapl.modelTest;

import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Location;
import ar.edu.unq.desapp.grupoB.bakenddesappapl.model.Project;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class ProjectTest {
        Project project;
        Location quilmes;
        LocalDate dateInit;
        LocalDate dateEnd;

        @BeforeEach
        public void setUp(){
            dateInit = LocalDate.of(2020,05,01);
            dateEnd = LocalDate.of(2020,06,01);
            quilmes= new Location("Quilmes","Buenos Aires",10000,"NO");
            project = new Project("ProjectInitial",10,100, dateInit,dateEnd,quilmes);
        }
        @Test
        public void test01aNewProjectIsCreatedAndIVerifyItsName(){
            assertEquals(project.getNameProject(),"ProjectInitial");
        }

        @Test
        public void test02OfTheNewProjectIVerifyItsLocation(){
            assertEquals(project.getLocation(),quilmes);
        }

       // @Test
   //     public void test03OfTheNewProjectIVerifyItsStartDateAndEndDate(){

      //  }


}
