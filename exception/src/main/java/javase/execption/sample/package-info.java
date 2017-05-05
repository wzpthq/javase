/**
 * | --- Throwable
 * | --- --- Error
 * | --- --- --- OutOfMemoryError
 * | --- --- --- StackOverflowError
 * | --- --- Exception
 * | --- --- --- RuntimeException
 * | --- --- --- IOException
 *
 * 异常和错误：
 * 一般错误是程序无法自行恢复；异常可以分为检查性异常和非检查性异常，非检查性异常主要是继承于RuntimeException，发生在
 * 运行期间。
 *
 * 错误也是非检查性异常，
 * 错误和异常最大的却别在于，异常是可以程序处理的，但是错误是程序无法处理的
 * Created by wangzhiping on 17/5/3.
 */
package javase.execption.sample;