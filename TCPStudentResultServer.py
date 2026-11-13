"""Tutorial 11 - Question 1: TCP server for student examination results."""

import socket

HOST = "127.0.0.1"
PORT = 5000

# Sample register-number and result records.
student_results = {
    "RA101": "Pass - CGPA: 8.2",
    "RA102": "Pass - CGPA: 7.8",
    "RA103": "Needs improvement - CGPA: 6.1",
}


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as server:
        server.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)
        server.bind((HOST, PORT))
        server.listen(5)
        print(f"Result server is running on {HOST}:{PORT}")

        while True:
            connection, address = server.accept()
            with connection:
                print("Connected by:", address)
                register_number = connection.recv(1024).decode().strip().upper()
                result = student_results.get(
                    register_number, "Register number not found."
                )
                connection.sendall(result.encode())
                print(f"Request: {register_number} | Response: {result}")


if __name__ == "__main__":
    main()
