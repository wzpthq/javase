/**
 * 关于流如何区分呢？
 * 主要包含
 * 1、字节流: InputStream | OutputStream
 * | --- InputStream
 * | --- --- FileInputStream
 * | --- --- --- SocketInputStream
 * | --- --- ByteArrayInputStream
 * | --- --- FilterInputStream
 * | --- --- --- DataInputStream
 * | --- --- --- ObjectInputStream
 * | --- --- --- BufferedInputStream
 * | --- OutputStream
 * | --- --- FileOutputStream
 * | --- --- --- SocketOutputStream
 * | --- --- ByteArrayOutputStream
 * | --- --- FilterOutputStream
 * | --- --- --- DataOutputStream
 * | --- --- --- ObjectOutputStream
 * | --- --- --- BufferedOutputStream
 *
 * 2、字符流: Reader | Writer
 * | --- Reader
 * | --- --- InputStreamReader
 * | --- --- --- FileReader
 * | --- --- BufferedReader
 * | --- Writer
 * | --- --- OutputStreamWriter
 * | --- --- --- FileWriter
 * | --- --- BufferedWriter
 *
 * Created by wangzhiping on 17/5/4.
 */
package javase.io.stream;