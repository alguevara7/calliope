package net.ushadow.calliope

import com.google.appengine.api.datastore.Entity

class InMemoryEvent(
  private val _kind: String,
  private val nameValues: Map[String, Object]) extends Event {

  def kind = _kind
  def properties = nameValues
}
