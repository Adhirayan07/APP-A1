"""Q1: TCP client that requests a student's examination result."""

import socket

HOST = "127.0.0.1"
PORT = 5000


def main():
    register_number = input("Enter student register number: ").strip().upper()

    # TCP uses SOCK_STREAM.
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client:
        client.connect((HOST, PORT))
        client.sendall(register_number.encode())
        result = client.recv(1024).decode()

    print("Result from server:", result)


if __name__ == "__main__":
    main()
