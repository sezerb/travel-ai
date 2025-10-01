# Travel Recommendation Engine

##
Link: https://www.docker.com/blog/run-llms-locally/

__Note__:
In its default configuration, the Model Runner will only be accessible through the Docker socket on the host, or to containers via the special model-runner.docker.internal endpoint. If you want to interact with it via TCP from a host process (maybe because you want to point some OpenAI SDK within your codebase straight to it), you can also enable it via CLI by specifying the intended port:

```
docker desktop enable model-runner --tcp 12434
```