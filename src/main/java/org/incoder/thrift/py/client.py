#  Copyright (C) 2019 The Jerry xu Open Source Project
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#       http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.

# _*_ coding:utf-8 _*_
__author__ = 'Jerry xu'

from generate import PersonService
from generate import ttypes

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TCompactProtocol

try:
    tSocket = TSocket.TSocket('localhost', 9090)
    tSocket.setTimeout(600)

    transport = TTransport.TFramedTransport(tSocket)
    protocol = TCompactProtocol.TCompactProtocol(transport)
    client = PersonService.Client(protocol)

    transport.open()
    person = client.getPersonByUsername("张三")
    print("username：" + person.username)
    print("age：" + str(person.age))
    print("married：" + str(person.married))

    print("------------------------")
    newPerson = ttypes.Person()
    newPerson.username = "李四"
    newPerson.age = 30
    newPerson.married = True

    client.savePerson(newPerson)
    transport.close()
except Thrift.TException as tx:
    print(tx.message)
