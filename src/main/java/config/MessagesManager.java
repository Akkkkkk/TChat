package config;

import minealex.tchat.TChat;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class MessagesManager {

    private final ConfigFile messagesFile;
    private final TChat plugin;
    private String noPermission;
    private String versionMessage;
    private String reloadMessage;
    private String unknownMessage;
    private String prefix;
    private String noFormatGroup;
    private String noPlayer;
    private String antiCapMessage;
    private String colorSelectedMessage;
    private String formatSelectedMessage;
    private String invalidIdMessage;
    private String noItemFoundMessage;
    private String materialNotFound;
    private String usageChannel;
    private String usageJoinChannel;
    private String usageLeaveChannel;
    private String channelNotExist;
    private String channelNoPermissionJoin;
    private String channelAlready;
    private String channelLeft;
    private String channelJoin;
    private String channelLeftAnnounce;
    private String channelJoinAnnounce;
    private String noChannel;
    private String noPermissionChannelLeft;
    private String playerNotFound;
    private String usageMsg;
    private String usageReply;
    private String noReply;
    private String chatClearMessage;
    private String chatMuted;
    private String chatMute;
    private String chatUnmute;
    private String repeatMessage;
    private String antibotChat;
    private String antibotCommand;
    private String antibotJoin;
    private String antibotMoved;
    private String noGames;
    private String noEnabledGames;
    private String noMessages;
    private String timeFinished;
    private String gameWin;
    private String cooldownChat;
    private String cooldownCommand;
    private String antiFlood;
    private String customCommandsCooldown;
    private String ping;
    private String broadcastUsage;
    private String ignoreUsage;
    private String ignoreSelf;
    private String ignoreAlready;
    private String ignoreMessage;
    private String pollMessage;
    private String pollOptionsMessage;
    private String endTitle;
    private String endTextTitle;
    private String optionLine;
    private String progressBar;
    private String usagePoll;
    private String usagePollCreate;
    private String durationNumber;
    private String oneOption;
    private String usagePollVote;
    private String noPoll;
    private String invalidOptionPoll;
    private String votePoll;
    private String pollCreate;
    private String startTitle;
    private String startText;
    private String startOptionLine;
    private String startProgressBar;
    private String updateTitle;
    private String updateText;
    private String updateOptionLine;
    private String updateProgressBar;
    private String antiUnicode;
    private String levelUp;
    private String printUsage;
    private List<String> chatMessage;
    private String chatDisabledWorld;
    private String ignoreListEmpty;
    private String ignoreListMessage;
    private String usageWarning;
    private String usageAnnouncement;
    private String autoBroadcastUsage;
    private String autoBroadcastStart;
    private String autoBroadcastStop;
    private String autoBroadcastRestart;
    private String autoBroadcastUsageRemove;
    private String autoBroadcastRemove;
    private String autoBroadcastUsageAdd;
    private String autoBroadcastAddEnabled;
    private String autoBroadcastAddNewLine;
    private String autoBroadcastAddOneLine;
    private String autoBroadcastAddAdded;
    private String autoBroadcastActionsPrompt;
    private List<String> pluginMessage;
    private String pluginUsage;
    private String pluginNotFound;
    private String depurationChatCooldown;
    private String depurationCommandCooldown;
    private String usageBannedCommands;
    private String usageSendChannel;
    private String customCommandsArguments;
    private String usageBannedCommandsList;
    private String bannedCommandsNoCommandsBlocked;
    private String bannedCommandsBlockedList;
    private String bannedCommandsNoTabBlocked;
    private String bannedCommandsBlockedTabList;
    private String usageBannedCommandsAdd;
    private String bannedCommandsAlready;
    private String bannedCommandsAlreadyTab;
    private String bannedCommandsAdded;
    private String bannedCommandsAddedTab;
    private String usageBannedCommandsRemove;
    private String bannedCommandsNotBlocked;
    private String bannedCommandsNotBlockedTab;
    private String bannedCommandsRemoved;
    private String bannedCommandsRemovedTab;
    private String depurationAntiFlood;
    private String helpOp;
    private String usageHelpOp;
    private String usageCalculator;
    private String invalidOperator;
    private String divisionZero;
    private String calculatorResult;
    private String invalidNumber;
    private String invalidColor;
    private String colorReset;
    private String usagePlayer;
    private List<String> playerMessage;
    private List<String> playerMessageAdmin;
    private String otherPing;
    private List<String> serverMessage;
    private String usageSocialSpy;
    private String alreadyEnabledSpy;
    private String alreadyDisabledSpy;
    private String enabledSpy;
    private String disabledSpy;
    private String invalidModeSpy;
    private String modeSpy;
    private String usageCommandTimer;
    private String usageCommandTimerAdd;
    private String usageCommandTimerRemove;
    private String commandTimerAdded;
    private String commandTimerAlreadyAdded;
    private String commandTimerInvalidNumber;
    private String commandTimerRemoved;
    private String commandTimerNotExist;

    public MessagesManager(TChat plugin){
        this.messagesFile = new ConfigFile("messages.yml", null, plugin);
        this.plugin = plugin;
        this.messagesFile.registerConfig();
        loadConfig();
    }

    public void loadConfig(){
        FileConfiguration config = messagesFile.getConfig();
        boolean prefixEnabled = config.getBoolean("prefix.enabled");
        if (prefixEnabled) {
            prefix = config.getString("prefix.prefix");
        } else {
            prefix = "";
        }

        if (plugin.getConfigManager().isCooldownChat()) {
            cooldownChat = config.getString("messages.cooldown.chat");
            depurationChatCooldown = config.getString("messages.debug.chat-cooldown");
        }
        if (plugin.getConfigManager().isCooldownCommand()) {
            cooldownCommand = config.getString("messages.cooldown.command");
            depurationCommandCooldown = config.getString("messages.debug.command-cooldown");
        }

        if (plugin.getConfigManager().isAntibotEnabled()) {
            if (plugin.getConfigManager().isAntibotChat()) {
                antibotChat = config.getString("messages.antibot.antibot-chat");
            }
            if (plugin.getConfigManager().isAntibotCommand()) {
                antibotCommand = config.getString("messages.antibot.antibot-command");
            }
            if (plugin.getConfigManager().isAntibotJoin()) {
                antibotJoin = config.getString("messages.antibot.antibot-join");
            }
            if (plugin.getConfigManager().isAntibotMoved()) {
                antibotMoved = config.getString("messages.antibot.antibot-moved");
            }
        }

        if (plugin.getConfigManager().isUnicodeEnabled()) {
            antiUnicode = config.getString("messages.unicode");
        }

        if (plugin.getConfigManager().isFloodPercentEnabled() || plugin.getConfigManager().isFloodRepeatEnabled()) {
            antiFlood = config.getString("messages.anti-flood");
            if (plugin.getConfigManager().isDepurationAntiFloodEnabled()) {
                depurationAntiFlood = config.getString("messages.debug.anti-flood");
            }
        }

        if (plugin.getConfigManager().isBroadcastEnabled()) {
            broadcastUsage = config.getString("messages.usage.usage-broadcast");
        }

        if (plugin.getConfigManager().isWarningEnabled()) {
            usageWarning = config.getString("messages.usage.usage-warning");
        }

        if (plugin.getConfigManager().isAnnouncementEnabled()) {
            usageAnnouncement = config.getString("messages.usage.usage-announcement");
        }

        if (plugin.getConfigManager().isPrintEnabled()) {
            printUsage = config.getString("messages.usage.usage-print");
        }

        if (plugin.getConfigManager().isIgnoreEnabled()) {
            ignoreSelf = config.getString("messages.ignore.ignore-self");
            ignoreAlready = config.getString("messages.ignore.already-ignored");
            ignoreMessage = config.getString("messages.ignore.ignore");
            ignoreUsage = config.getString("messages.usage.usage-ignore");
            ignoreListMessage = config.getString("messages.ignore.ignore-list-message");
            ignoreListEmpty = config.getString("messages.ignore.ignore-list-empty");
        }

        if (plugin.getConfigManager().isChatColorEnabled()) {
            colorReset = config.getString("messages.color-reset");
            invalidColor = config.getString("messages.invalid-color");
            colorSelectedMessage = config.getString("messages.color-selected");
            noItemFoundMessage = config.getString("messages.no-item-found");
            invalidIdMessage = config.getString("messages.invalid-id");
            formatSelectedMessage = config.getString("messages.format-selected");
        }

        if (plugin.getConfigManager().isPingEnabled()) {
            ping = config.getString("messages.ping");
            otherPing = config.getString("messages.other-ping");
        }

        if (plugin.getConfigManager().isSpyEnabled()) {
            usageSocialSpy = config.getString("messages.usage.usage-socialspy");
            alreadyEnabledSpy = config.getString("messages.socialspy.already-enabled");
            alreadyDisabledSpy = config.getString("messages.socialspy.already-disabled");
            enabledSpy = config.getString("messages.socialspy.enabled");
            disabledSpy = config.getString("messages.socialspy.disabled");
            modeSpy = config.getString("messages.socialspy.mode");
            invalidModeSpy = config.getString("messages.socialspy.invalid-mode");
        }

        // Messages
        commandTimerInvalidNumber = config.getString("messages.commandtimer.invalid-number");
        commandTimerRemoved = config.getString("messages.commandtimer.removed");
        commandTimerAdded = config.getString("messages.commandtimer.added");
        commandTimerAlreadyAdded = config.getString("messages.commandtimer.already-added");
        commandTimerNotExist = config.getString("messages.commandtimer.not-exist");;
        usageCommandTimer = config.getString("messages.usage.usage-commandtimer");
        usageCommandTimerRemove = config.getString("messages.usage.usage-commandtimer-remove");
        usageCommandTimerAdd = config.getString("messages.usage.usage-commandtimer-add");
        serverMessage = config.getStringList("server");
        playerMessageAdmin = config.getStringList("player.admin");
        playerMessage = config.getStringList("player.global");
        usagePlayer = config.getString("messages.usage.usage-player");
        divisionZero = config.getString("messages.division-zero");
        invalidOperator = config.getString("messages.invalid-operator");
        invalidNumber = config.getString("messages.invalid-number");
        calculatorResult = config.getString("messages.calculator-result");
        usageCalculator = config.getString("messages.usage.usage-calculator");
        usageHelpOp = config.getString("messages.usage.usage-helpop");
        helpOp = config.getString("messages.helpop");
        bannedCommandsRemoved = config.getString("messages.bannedcommands.removed");
        bannedCommandsRemovedTab = config.getString("messages.bannedcommands.removed-tab");
        bannedCommandsNotBlocked = config.getString("messages.bannedcommands.not-blocked");
        bannedCommandsNotBlockedTab = config.getString("messages.bannedcommands.not-blocked-tab");
        usageBannedCommandsRemove = config.getString("messages.usage.usage-remove-bc");
        bannedCommandsAdded = config.getString("messages.bannedcommands.added");
        bannedCommandsAddedTab = config.getString("messages.bannedcommands.added-tab");
        bannedCommandsAlready = config.getString("messages.bannedcommands.already");
        bannedCommandsAlreadyTab = config.getString("messages.bannedcommands.already-tab");
        usageBannedCommandsAdd = config.getString("messages.usage.usage-add-bc");
        bannedCommandsBlockedList = config.getString("messages.bannedcommands.blocked-list");
        bannedCommandsBlockedTabList = config.getString("messages.bannedcommands.no-tab-blocked");
        bannedCommandsNoCommandsBlocked = config.getString("messages.bannedcommands.no-commands-blocked");
        bannedCommandsNoTabBlocked = config.getString("messages.bannedcommands.blocked-tab-list");
        usageBannedCommandsList = config.getString("messages.usage.usage-list-bannedcommands");
        customCommandsArguments = config.getString("messages.cc-arguments");
        usageSendChannel = config.getString("messages.usage.usage-send-channel");
        usageBannedCommands = config.getString("messages.usage.usage-bannedcommands");
        pluginNotFound = config.getString("messages.plugin-not-found");
        pluginUsage = config.getString("messages.usage.usage-plugin");
        pluginMessage = config.getStringList("plugin");
        autoBroadcastActionsPrompt = config.getString("messages.autobroadcast.create.actions-prompt");
        autoBroadcastAddOneLine = config.getString("messages.autobroadcast.create.one-line");
        autoBroadcastAddNewLine = config.getString("messages.autobroadcast.create.new-line");
        autoBroadcastAddAdded = config.getString("messages.autobroadcast.create.added");
        autoBroadcastAddEnabled = config.getString("messages.autobroadcast.create.enabled");
        autoBroadcastUsageRemove = config.getString("messages.autobroadcast.usage-remove");
        autoBroadcastUsageAdd = config.getString("messages.autobroadcast.usage-add");
        autoBroadcastStop = config.getString("messages.autobroadcast.stop");
        autoBroadcastStart = config.getString("messages.autobroadcast.start");
        autoBroadcastRestart = config.getString("messages.autobroadcast.restart");
        autoBroadcastRemove = config.getString("messages.autobroadcast.removed");
        autoBroadcastUsage = config.getString("messages.usage.usage-autobroadcast");
        chatDisabledWorld = config.getString("messages.chat-disabled-world");
        chatMessage = config.getStringList("messages.chat-help.message");
        levelUp = config.getString("messages.level-up");
        updateProgressBar = config.getString("messages.poll.message.update.progress-bar");
        updateTitle = config.getString("messages.poll.message.update.title");
        updateText = config.getString("messages.poll.message.update.text");
        updateOptionLine = config.getString("messages.poll.message.update.option-line");
        startProgressBar = config.getString("messages.poll.message.start.progress-bar");
        startOptionLine = config.getString("messages.poll.message.start.option-line");
        startTitle = config.getString("messages.poll.message.start.title");
        startText = config.getString("messages.poll.message.start.text");
        pollCreate = config.getString("messages.poll-create");
        votePoll = config.getString("messages.vote");
        invalidOptionPoll = config.getString("messages.invalid-option-poll");
        noPoll = config.getString("messages.no-poll");
        usagePollVote = config.getString("messages.usage.usage-poll-vote");
        oneOption = config.getString("messages.one-option");
        durationNumber = config.getString("messages.duration-number");
        usagePollCreate = config.getString("messages.usage.usage-poll-create");
        usagePoll = config.getString("messages.usage.usage-poll");
        optionLine = config.getString("messages.poll.message.end.option-line");
        progressBar = config.getString("messages.poll.message.end.progress-bar");
        endTextTitle = config.getString("messages.poll.message.end.text");
        endTitle = config.getString("messages.poll.message.end.title");
        pollOptionsMessage = config.getString("messages.poll.join.message-options");
        pollMessage = config.getString("messages.poll.join.message");
        customCommandsCooldown = config.getString("messages.custom-commands-cooldown");
        noGames = config.getString("messages.chatgames.no-games");
        noEnabledGames = config.getString("messages.chatgames.no-enabled-games");
        noMessages = config.getString("messages.chatgames.no-messages");
        timeFinished = config.getString("messages.chatgames.time-finished");
        gameWin = config.getString("messages.chatgames.win");
        repeatMessage = config.getString("messages.repeat-message");
        chatUnmute = config.getString("messages.chat-unmute");
        chatMute = config.getString("messages.chat-mute");
        chatMuted = config.getString("messages.chat-muted");
        chatClearMessage = config.getString("messages.chat-clear");
        noReply = config.getString("messages.no-reply");
        usageMsg = config.getString("messages.usage.usage-msg");
        usageReply = config.getString("messages.usage.usage-reply");
        playerNotFound = config.getString("messages.player-not-found");
        noPermissionChannelLeft = config.getString("messages.channel.channel-no-permission-left");
        noChannel = config.getString("messages.channel.no-channel");
        channelLeftAnnounce = config.getString("messages.channel.left-channel-announce");
        channelJoinAnnounce = config.getString("messages.channel.join-channel-announce");
        channelJoin = config.getString("messages.channel.join-channel");
        channelLeft = config.getString("messages.channel.left-channel");
        channelAlready = config.getString("messages.channel.already-channel");
        channelNoPermissionJoin = config.getString("messages.channel.channel-no-permission-join");
        channelNotExist = config.getString("messages.channel.channel-not-exist");
        usageLeaveChannel = config.getString("messages.usage.leave-channel");
        usageJoinChannel = config.getString("messages.usage.join-channel");
        noPermission = config.getString("messages.no-permission");
        versionMessage = config.getString("messages.version-message");
        reloadMessage = config.getString("messages.reload-message");
        unknownMessage = config.getString("messages.unknown-command");
        antiCapMessage = config.getString("messages.anticap");
        usageChannel = config.getString("messages.usage.channel");

        // Messages depuration
        materialNotFound = config.getString("messages.debug.material-not-found");
        noFormatGroup = config.getString("messages.debug.no-format-group");
        noPlayer = config.getString("messages.debug.no-player");
    }

    public void reloadConfig(){
        messagesFile.reloadConfig();
        loadConfig();
    }

    // Messages
    public String getCommandTimerNotExist() { return commandTimerNotExist; }
    public String getCommandTimerRemoved() { return commandTimerRemoved; }
    public String getCommandTimerAlreadyAdded() { return commandTimerAlreadyAdded; }
    public String getCommandTimerAdded() { return commandTimerAdded; }
    public String getCommandTimerInvalidNumer() { return commandTimerInvalidNumber; }
    public String getUsageCommandTimerRemove() { return usageCommandTimerRemove; }
    public String getUsageCommandTimerAdd() { return usageCommandTimerAdd; }
    public String getUsageCommandTimer() { return usageCommandTimer; }
    public String getInvalidModeSpy() { return invalidModeSpy; }
    public String getModeSpy() { return modeSpy; }
    public String getAlreadyEnabledSpy() { return alreadyEnabledSpy; }
    public String getAlreadyDisabledSpy() { return alreadyDisabledSpy; }
    public String getDisabledSpy() { return disabledSpy; }
    public String getEnabledSpy() { return enabledSpy; }
    public String getUsageSocialSpy() { return usageSocialSpy; }
    public List<String> getServerMessage() { return serverMessage; }
    public String getOtherPing() { return otherPing; }
    public List<String> getPlayerMessageAdmin() { return playerMessageAdmin; }
    public List<String> getPlayerMessage() { return playerMessage; }
    public String getUsagePlayer() { return usagePlayer; }
    public String getColorReset() { return colorReset; }
    public String getInvalidColor() { return invalidColor; }
    public String getInvalidNumber() { return invalidNumber; }
    public String getCalculatorResult() { return calculatorResult; }
    public String getDivisionZero() { return divisionZero; }
    public String getInvalidOperator() { return invalidOperator; }
    public String getUsageCalculator() { return usageCalculator; }
    public String getUsageHelpOp() { return usageHelpOp; }
    public String getHelpOp() { return helpOp; }
    public String getDepurationAntiFlood() { return depurationAntiFlood; }
    public String getBannedCommandsNotBlocked() { return bannedCommandsNotBlocked; }
    public String getBannedCommandsNotBlockedTab() { return bannedCommandsNotBlockedTab; }
    public String getBannedCommandsRemoved() { return bannedCommandsRemoved; }
    public String getBannedCommandsRemovedTab() { return bannedCommandsRemovedTab; }
    public String getUsageBannedCommandsRemove() { return usageBannedCommandsRemove; }
    public String getBannedCommandsAddedTab() { return bannedCommandsAddedTab; }
    public String getBannedCommandsAdded() { return bannedCommandsAdded; }
    public String getBannedCommandsAlreadyTab() { return bannedCommandsAlreadyTab; }
    public String getBannedCommandsAlready() { return bannedCommandsAlready; }
    public String getUsageBannedCommandsAdd() { return usageBannedCommandsAdd; }
    public String getBannedCommandsNoCommandsBlocked() { return bannedCommandsNoCommandsBlocked; }
    public String getBannedCommandsBlockedList() { return bannedCommandsBlockedList; }
    public String getBannedCommandsNoTabBlocked() { return bannedCommandsNoTabBlocked; }
    public String getBannedCommandsBlockedTabList() { return bannedCommandsBlockedTabList; }
    public String getUsageBannedCommandsList() { return usageBannedCommandsList; }
    public String getCustomCommandsArguments() { return customCommandsArguments; }
    public String getUsageSendChannel() { return usageSendChannel; }
    public String getUsageBannedCommands() { return usageBannedCommands; }
    public String getPluginNotFound() { return pluginNotFound; }
    public String getPluginUsage() { return pluginUsage; }
    public List<String> getPluginMessage() { return pluginMessage; }
    public String getAutoBroadcastActionsPrompt() { return autoBroadcastActionsPrompt; }
    public String getAutoBroadcastAddAdded() { return autoBroadcastAddAdded; }
    public String getAutoBroadcastAddOneLine() { return autoBroadcastAddOneLine; }
    public String getAutoBroadcastAddNewLine() { return autoBroadcastAddNewLine; }
    public String getAutoBroadcastAddEnabled() { return autoBroadcastAddEnabled; }
    public String getAutoBroadcastUsageAdd() { return autoBroadcastUsageAdd; }
    public String getAutoBroadcastRemove() { return autoBroadcastRemove; }
    public String getAutoBroadcastUsageRemove() { return autoBroadcastUsageRemove; }
    public String getAutoBroadcastRestart() { return autoBroadcastRestart; }
    public String getAutoBroadcastStop() { return autoBroadcastStop; }
    public String getAutoBroadcastStart() {return autoBroadcastStart; }
    public String getAutoBroadcastUsage() { return autoBroadcastUsage; }
    public String getUsageAnnouncement() { return usageAnnouncement; }
    public String getUsageWarning() { return usageWarning; }
    public String getIgnoreListMessage() { return ignoreListMessage; }
    public String getIgnoreListEmpty() { return ignoreListEmpty; }
    public String getChatDisabledWorld() { return chatDisabledWorld; }
    public List<String> getChatMessage() { return chatMessage; }
    public String getPrintUsage() { return printUsage; }
    public String getLevelUp() { return levelUp; }
    public String getAntiUnicode() { return antiUnicode; }
    public String getUpdateProgressBar() { return updateProgressBar; }
    public String getUpdateOptionLine() { return updateOptionLine; }
    public String getUpdateText() { return updateText; }
    public String getUpdateTitle() { return updateTitle; }
    public String getStartProgressBar() { return startProgressBar; }
    public String getStartOptionLine() { return startOptionLine; }
    public String getStartText() { return startText; }
    public String getStartTitle() { return startTitle; }
    public String getPollCreate() { return pollCreate; }
    public String getVotePoll() { return votePoll; }
    public String getInvalidOptionPoll() { return invalidOptionPoll; }
    public String getNoPoll() { return noPoll; }
    public String getUsagePollVote() { return usagePollVote; }
    public String getOneOption() { return oneOption; }
    public String getDurationNumber() { return durationNumber; }
    public String getUsagePollCreate() { return usagePollCreate; }
    public String getUsagePoll() { return usagePoll; }
    public String getProgressBar() { return progressBar; }
    public String getOptionLine() { return optionLine; }
    public String getEndTextTitle() { return endTextTitle; }
    public String getEndTitle() { return endTitle; }
    public String getPollOptionsMessage() { return pollOptionsMessage; }
    public String getPollMessage() { return pollMessage; }
    public String getIgnoreMessage() { return ignoreMessage; }
    public String getIgnoreAlready() { return ignoreAlready; }
    public String getIgnoreSelf() { return ignoreSelf; }
    public String getIgnoreUsage() { return ignoreUsage; }
    public String getBroadcastUsage() { return broadcastUsage; }
    public String getPing() { return ping; }
    public String getCustomCommandsCooldown() { return customCommandsCooldown; }
    public String getAntiFlood() { return antiFlood; }
    public String getCooldownCommand() { return cooldownCommand; }
    public String getCooldownChat() { return cooldownChat; }
    public String getGameWin() { return gameWin; }
    public String getTimeFinished() { return timeFinished; }
    public String getNoEnabledGames() { return noEnabledGames; }
    public String getNoGames() { return noGames; }
    public String getNoMessages() { return noMessages; }
    public String getAntibotMoved() { return antibotMoved; }
    public String getAntibotJoin() { return antibotJoin; }
    public String getAntibotCommand() { return antibotCommand; }
    public String getAntibotChat() { return antibotChat; }
    public String getRepeatMessage() { return repeatMessage; }
    public String getChatUnmute() { return chatUnmute; }
    public String getChatMute() { return chatMute; }
    public String getChatMuted() { return chatMuted; }
    public String getChatClearMessage() { return chatClearMessage; }
    public String getNoReply() { return noReply; }
    public String getUsageReply() { return usageReply; }
    public String getUsageMsg() { return usageMsg; }
    public String getPlayerNotFound() { return playerNotFound; }
    public String getNoPermissionChannelLeft() { return noPermissionChannelLeft; }
    public String getNoChannel() { return noChannel; }
    public String getChannelJoinAnnounce() { return channelJoinAnnounce; }
    public String getChannelLeftAnnounce() { return channelLeftAnnounce; }
    public String getChannelJoin() { return channelJoin; }
    public String getChannelLeft() { return channelLeft; }
    public String getChannelAlready() { return channelAlready; }
    public String getChannelNoPermissionJoin() { return channelNoPermissionJoin; }
    public String getChannelNotExist() { return channelNotExist; }
    public String getUsageLeaveChannel() { return usageLeaveChannel; }
    public String getUsageJoinChannel() { return usageJoinChannel; }
    public String getUsageChannel() { return usageChannel; }
    public String getNoItemFoundMessage() { return noItemFoundMessage; }
    public String getInvalidIdMessage() { return invalidIdMessage; }
    public String getFormatSelectedMessage() { return formatSelectedMessage; }
    public String getColorSelectedMessage() { return colorSelectedMessage; }
    public String getVersionMessage(){ return versionMessage; }
    public String getNoPermission(){ return noPermission; }
    public String getReloadMessage(){ return reloadMessage;}
    public String getUnknownMessage(){ return unknownMessage; }
    public String getPrefix() { return prefix; }
    public String getAntiCapMessage() { return antiCapMessage; }

    // Depuration
    public String getDepurationCommandCooldown() { return depurationCommandCooldown; }
    public String getDepurationChatCooldown() { return depurationChatCooldown; }
    public String getMaterialNotFound() { return materialNotFound; }
    public String getNoPlayer() { return noPlayer; }
    public String getNoFormatGroup() { return noFormatGroup; }
}
