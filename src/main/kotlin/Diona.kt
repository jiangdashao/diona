package me.rerere

import kotlinx.coroutines.launch
import me.rerere.commands.DionaCommand
import net.mamoe.mirai.console.command.CommandManager
import net.mamoe.mirai.console.permission.Permission
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescription
import net.mamoe.mirai.console.plugin.jvm.KotlinPlugin
import net.mamoe.mirai.event.events.GroupMessageEvent
import net.mamoe.mirai.event.globalEventChannel
import net.mamoe.mirai.message.data.At
import net.mamoe.mirai.message.data.buildMessageChain
import net.mamoe.mirai.message.data.content
import net.mamoe.mirai.utils.info

object Diona : KotlinPlugin(
    JvmPluginDescription(
        id = "me.rerere.diona",
        name = "DionaBot",
        version = "1.0",
    ) {
        author("RE")
        info("""AntiSpam""")
    }
) {
    override fun onEnable() {
        CommandManager.registerCommand(DionaCommand)

        globalEventChannel().apply {
            subscribeAlways<GroupMessageEvent> {
                Diona.launch {
                    if (!message.content.startsWith("/")) {
                        group.sendMessage(message.content)
                    }
                }
            }

            exceptionHandler {
                it.printStackTrace()
            }
        }

        logger.info { "Plugin loaded" }
    }
}