package me.rerere.commands

import kotlinx.coroutines.delay
import me.rerere.Diona
import me.rerere.utils.measureCodeTime
import net.mamoe.mirai.console.command.CompositeCommand
import net.mamoe.mirai.console.command.ConsoleCommandSender
import net.mamoe.mirai.console.command.MemberCommandSender
import net.mamoe.mirai.console.command.UserCommandSender

object DionaCommand : CompositeCommand(
    Diona, "diona",
    description = "diona bot command",
) {
    @SubCommand
    suspend fun MemberCommandSender.reload() {
        val timer = measureCodeTime {
            delay(1000)
        }
        sendMessage("重载完成，耗时 $timer ms")
    }

    @SubCommand("help", "帮助")
    suspend fun MemberCommandSender.help() {
        group.sendMessage("1111")
    }
}