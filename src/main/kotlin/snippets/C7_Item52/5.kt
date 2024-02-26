package f_C7_Item52.s_5

@JvmInline
value class StudentId(val value: String)

@JvmInline
value class ClassId(val value: String)

data class Student(val id: StudentId, val classId: ClassId)
