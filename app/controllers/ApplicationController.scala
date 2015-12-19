package controllers

import javax.inject.{Inject, Named}

import models.{Person, PersonRepository}
import play.api.mvc._

@Named
class ApplicationController @Inject()(personRepository: PersonRepository) extends Controller {

  def index() = Action {
    val person: Person = new Person
    person.name = "Bruce Smith"

    personRepository.save(person)
    Ok(views.html.index(personRepository.count() + " documents in repo."))
  }

}
