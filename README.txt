This project is based in queue architecture, developed using java, spring boot and the queue broker used is the rabbitMQ.
The main pourpose of this project is to see the funcionality of the queue process and understand how the broker divide tasks and
define priority.
The project reads a csv file with fictional transactions and send the transactions to the rabbit broker where there are another projec that read the queue
and consume it writing in terminal, so if the transaction have its value higher than 40.000 this consumer send it to an exchange thathas 2 queues
associated with it and writes too in the terminal this suspected transactions, thats it!!
