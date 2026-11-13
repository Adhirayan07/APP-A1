"""Tutorial 11 - Question 2: UDP temperature monitoring server."""

import socket

HOST = "127.0.0.1"
PORT = 5001


def main():
    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as server:
        server.bind((HOST, PORT))
        print(f"Temperature server is listening on {HOST}:{PORT}")

        while True:
            data, address = server.recvfrom(1024)
            message = data.decode().strip()

            if message.upper() == "END":
                print("Sensor client finished sending readings.")
                break

            print(f"Temperature received from {address}: {message}")


if __name__ == "__main__":
    main()
