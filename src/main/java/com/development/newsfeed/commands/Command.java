package com.development.newsfeed.commands;

public interface Command {

    public boolean match(String input);
    public void execute(String input);
}
