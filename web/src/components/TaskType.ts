export enum Status {
  BACKLOG = "BACKLOG",
  DO = "DO",
  DOING = "DOING",
  DONE = "DONE",
}

export enum Priority {
  LOW = "LOW",
  MEDIUM = "MEDIUM",
  HIGH = "HIGH",
}

export interface TaskType {
  id?: String;
  title: String;
  description: String;
  status: Status;
  priority: Priority;
}
