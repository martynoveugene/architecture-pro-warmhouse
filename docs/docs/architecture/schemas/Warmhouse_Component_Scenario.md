```puml
@startuml
title WarmHouse Scenario Service Diagram

top to bottom direction

!includeurl https://raw.githubusercontent.com/RicardoNiepel/C4-PlantUML/master/C4_Component.puml

Container(APIGateway, "API Gateway", "REST", "Gateway routing calls")
ContainerDb(queueSate, "Queue sensor state changed messages", "RabbitMQ", "")
ContainerDb(queueInfo, "Queue sensor info changed messages", "RabbitMQ", "")

Container_Boundary(ScenarioMicroservice, "Scenario Microservice") {
    Component(ScenarioRestController, "RestController", "Go", "REST API to manage scenarios")

    Component(StateListener, "State Listener", "Consumer", "Business logic for state changes")
    Component(InfoListener, "Info Listener", "Consumer", "Listens to the queue for info changes")

    Component(ScenarioRegistry, "Scenario Registry", "", "Business logic for save/edit/delete/verify/schedule scenarios")

    Component(ScenarioScheduler, "Scenario Scheduler", "timer", "runs scenarios by timer")

    Component(PersistentLayer, "Persistent Layer", "CRUD", "save/restore data")

    Component(CommandProcessor, "Command Processor", "", "runs set of commands")

    ContainerDb(ScenarioDatabase, "ScenarioDatabase", "PostgreSQL", "Stores sensor scenarios")
}

System_Ext(sensor, "Set of Sensors", "External scope of the physical devices / External API")



Rel(APIGateway, ScenarioRestController, "/scenario/*")
Rel(queueInfo, InfoListener,"Consumes sensor info data")
Rel(queueSate, StateListener, "Consumes sensor change state messages", "AMQP")

Rel(ScenarioRestController, ScenarioRegistry, "updates scenario")
Rel(InfoListener, ScenarioRegistry, "updates info")

Rel(ScenarioRegistry, PersistentLayer, "")
Rel(ScenarioRegistry, ScenarioScheduler, "schedules")
Rel(PersistentLayer, ScenarioDatabase,"stores/retrieves scenarios and info")

Rel(ScenarioScheduler, CommandProcessor, "sends as commands")
Rel(StateListener, CommandProcessor,"transforms into commands")
Rel(StateListener, ScenarioRegistry,"gets scenario")
''Rel(InfoListener, CommandProcessor,"transforms into commands")

Rel(CommandProcessor, sensor,"runs commands")


@enduml
```