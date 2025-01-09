package ai.pipecat.gemini_multimodal_websocket_demo.ui

import ai.pipecat.gemini_multimodal_websocket_demo.VoiceClientManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InCallLayout(voiceClientManager: VoiceClientManager) {

    Column(Modifier.fillMaxSize()) {

        InCallHeader(expiryTime = voiceClientManager.expiryTime.value)

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically)
            ) {
                BotIndicator(
                    modifier = Modifier,
                    isReady = voiceClientManager.botReady.value,
                    isTalking = voiceClientManager.botIsTalking,
                    audioLevel = voiceClientManager.botAudioLevel
                )

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    UserMicButton(
                        onClick = voiceClientManager::toggleMic,
                        micEnabled = voiceClientManager.mic.value,
                        modifier = Modifier,
                        isTalking = voiceClientManager.userIsTalking,
                        audioLevel = voiceClientManager.userAudioLevel
                    )
                }
            }
        }

        InCallFooter(onClickEnd = voiceClientManager::stop)
    }
}
