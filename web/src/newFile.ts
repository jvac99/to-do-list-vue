export default (await import('vue')).defineComponent({
components: {
AddTask,
Header,
Tasks,
},
data() {
return {
tasks: [{
title: "Add Task",
}],
};
},
methods: {
const: handleTaskClick = (taskId: Int): void => {
const newTasks = this.tasks.map((task: Object) => {
if (task.id === taskId) return { ...task, completed: !task.completed };

return task;
});

setTasks(newTasks);
},

const: handleTaskAddition = (taskTitle) => {
const newTasks = [
...tasks,
{
title: taskTitle,
id: uuidv4(),
completed: false,
},
];

setTasks(newTasks);
},

const: handleTaskDeletion = (taskId) => {
const newTasks = tasks.filter((task) => task.id !== taskId);

setTasks(newTasks);
}
}
});
