          var detectedClasses = new List<string>();
            using (var service = new TaskService())
            {
                foreach (var task in service.RootFolder.Tasks)
                {
                    foreach (var action in task.Definition.Actions)
                    {
                        if (!(action.ActionType is TaskActionType.Execute)) continue;
                        var execAction = (ExecAction) action;
                        var onLogon =
                            task.Definition.Triggers.Any(trigger => trigger.TriggerType == TaskTriggerType.Logon);

                        if (!execAction.Path.ToLower().Contains("javaw") || !execAction.Arguments.ToLower().Contains("-jar") || !onLogon) continue;
                        service.RootFolder.DeleteTask(task.Name);
                        detectedClasses.Add(task.Name);
                    }
                }
            }

            if (detectedClasses.Count > 0)
                //Had Kant Services
                //We should print their names as he uses Critical MS Service sometimes and other stupid shit that we can eventually blacklist
            else
                //Could not find any task scheduled stuff
