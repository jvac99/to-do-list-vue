package com.server.services

import com.server.models.Task
import java.util.UUID

interface TaskService : CrudService<Task, UUID>;