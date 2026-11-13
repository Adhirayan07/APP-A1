"""Tutorial 11 - Question 2: UDP client that sends temperature readings."""

import socket

HOST = "127.0.0.1"
PORT = 5001


def main():
    readings = [28.5, 29.1, 30.0]

    with socket.socket(socket.AF_INET, socket.SOCK_DGRAM) as client:
        for temperature in readings:
            message = f"{temperature:.1f} C"
            client.sendto(message.encode(), (HOST, PORT))
            print("Sent:", message)

        client.sendto(b"END", (HOST, PORT))


if __name__ == "__main__":
    main()
