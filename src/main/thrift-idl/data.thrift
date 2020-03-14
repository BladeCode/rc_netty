// 定义命名空间
namespace java org.incoder.thrift.java
namespace py org.incoder.thrift.py

// 定义别名
typedef i16 short
typedef i32 int
typedef i64 long
typedef bool boolean
typedef string String

// 定义 struct
struct Person{
    1: optional String username,
    2: optional int age,
    3: optional boolean married
}

// 定义 exception
exception DataException{
    1: optional String message,
    2: optional String callStack,
    3: optional String date
}

// 定义 service
service PersonService{
    Person getPersonByUsername(1: required String username) throws (1: DataException dataException),

    void savePerson(1: required Person person) throws (1: DataException dataException)
}
