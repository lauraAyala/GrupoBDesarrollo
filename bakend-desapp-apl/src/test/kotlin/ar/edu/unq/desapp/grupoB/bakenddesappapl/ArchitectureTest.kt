package ar.edu.unq.desapp.grupoB.bakenddesappapl

import com.tngtech.archunit.junit.AnalyzeClasses
import com.tngtech.archunit.junit.ArchTest
import com.tngtech.archunit.lang.ArchRule
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes
import com.tngtech.archunit.lang.syntax.elements.ClassesShouldConjunction
import com.tngtech.archunit.library.Architectures.layeredArchitecture


@AnalyzeClasses(packages = arrayOf("ar.edu.unq.desapp.grupoB.backenddesappapl"))
class ArchitectureTest {

   /* @JvmOverloads
    @ArchTest
    fun final(  class_and_package_contaiment_checks: ClassesShouldConjunction? = classes()
    .that().haveSimpleNameStartingWith("LocationService")
    .should().resideInAPackage("ar.edu.unq.desapp.grupoB.backenddesappapl.service")) {
    }*/


  /*  @ArchTest
    val layer_dependencies_are_respected: ArchRule = layeredArchitecture()
            .layer("Controllers").definedBy("ar.edu.unq.desapp.grupoB.backenddesappapl.controller..")
            .layer("Services").definedBy("ar.edu.unq.desapp.grupoB.backenddesappapl.service..")
            .layer("Repository").definedBy("ar.edu.unq.desapp.grupoB.backenddesappapl.repository..")
            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers")
            .whereLayer("Repository").mayOnlyBeAccessedByLayers("Services")
*/
}
