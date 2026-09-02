package drill3_scope_func

data class Student(var name: String = "", var score: Int? = null, var kelas: String = "")

fun getGrading(student: Student): String {
    return student.score?.let {
        if (it >= 90) "A" else if (it >= 75) "B" else "C"
    } ?: "Belum dinilai"
}

fun saveStudent(student: Student):Student{
    val save = student.also {
        println("Menyimpan data: ${it.name}")
    }
    return save
}

fun main(){
    val student1 = Student().apply{
        name = "Dewi"
        score = 88
        kelas = "9"
    }

    val student2 = Student().apply {
        name = "Farhan"
        score = null
        kelas = "8"
    }

    val letterGrade1 = saveStudent(student1).let { getGrading(it) }
    println(letterGrade1)
    val letterGrade2 = saveStudent(student2).let { getGrading(it) }
    println(letterGrade2)

    with(student1){
        println("Siswa dengan $name kelas $kelas, memiliki nilai $score, dengan $letterGrade1")
    }
    with(student2){
        println("Siswa dengan $name kelas $kelas, memiliki nilai $score, dengan $letterGrade2")
    }
}