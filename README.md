# Java Single-Threaded Server-Client Model

This project demonstrates a simple single-threaded server-client model implemented in Java. The server listens for a single client connection, exchanges a message, and then closes the connection. This is a basic example suitable for learning about socket programming and inter-process communication in Java.

## Features
- **Single-threaded server:** Handles one client at a time.
- **Simple message exchange:** Server sends a greeting, client responds, and both print messages to the console.
- **Timeout:** The server socket has a timeout to avoid waiting indefinitely for connections.

## File Structure
- `src/server.java`: The server implementation.
- `src/client.java`: The client implementation.

## How It Works
### Server (`server.java`)
- Listens on port `8010` for incoming connections.
- When a client connects, sends a greeting message (`Hello from server`).
- Reads a message from the client and prints it.
- Closes the connection and waits for the next client (or exits on error).

### Client (`client.java`)
- Connects to the server at `localhost:8010`.
- Sends a message (`Hello from client`) to the server.
- Reads and prints the server's greeting message.
- Closes the connection.

## How to Run
1. **Compile the Java files:**
   ```sh
   javac src/server.java src/client.java
   ```
2. **Start the server:**
   ```sh
   java -cp src server
   ```
3. **In a new terminal, start the client:**
   ```sh
   java -cp src client
   ```

## Example Output
**Server:**
```
Server listening on port 8010
Connect address: /127.0.0.1:XXXXX
Hello from client
```

**Client:**
```
Hello from server
Client is done
```

## Notes
- This example is single-threaded: only one client can connect at a time.
- For multiple clients, consider using threads or thread pools in the server.
- The server will exit if an exception occurs (e.g., timeout or IO error).

## License
This project is for educational purposes.

