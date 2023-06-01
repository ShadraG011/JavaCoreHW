FROM bellsoft/liberica-openjdk-alpine:latest

COPY ./src ./src

RUN mkdir ./out

RUN javac -sourcepath ./src/main/java/ -d out src/main/java/ru/gb/jcore/hm1/sample/Main.java

CMD java -classpath ./out ru.gb.jcore.hm1.sample.Main