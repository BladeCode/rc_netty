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

# -*- coding: utf-8 -*-
__author__ = 'Jerry xu'

from generate import ttypes


class PersonHandler:

    def getPersonByUsername(self, username):
        print("Got client param:" + username)

        person = ttypes.Person()
        person.username = username
        person.age = 20
        person.married = False

        return person

    def savePerson(self, person):
        print("Got client param")

        print("username：" + person.username)
        print("age：" + str(person.age))
        print("married：" + str(person.married))
