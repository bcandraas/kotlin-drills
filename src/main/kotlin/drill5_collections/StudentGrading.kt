package drill5_collections

data class Student(val name: String, val score: Int, val gradeLevel: String)

fun main() {
    val students = listOf(
        Student("Sarah", 88, "Senior"),
        Student("Jake", 62, "Junior"),
        Student("Elena", 95, "Senior"),
        Student("Marcus", 74, "Sophomore"),
        Student("Tom", 81, "Junior")
    )

    // 1. filter: Keep only passing students (score >= 70)
    val passingStudents = students.filter { it.score >= 70 }
    println("Passed: ${passingStudents.map { it.name }}") // [Sarah, Elena, Marcus, Tom]

    // 2. map: Transform student objects into grade report strings
    val gradeReports = students.map { "${it.name}: ${it.score}%" }
    println("Reports: $gradeReports")

    // 3. groupBy: Bucket students by their grade level
    val byGradeLevel = students.groupBy { it.gradeLevel }
    println("Grouped: $byGradeLevel")

    // RECREATE: Filter even numbers from a list of test scores and double them
    val rawScores = listOf(71, 72, 85, 90, 94)
    val doubledEvenScores = rawScores
        .filter { score -> score % 2 == 0 }
        .map { score -> score * 2 }

    println("Doubled Evens: $doubledEvenScores") // [144, 180, 188]
}