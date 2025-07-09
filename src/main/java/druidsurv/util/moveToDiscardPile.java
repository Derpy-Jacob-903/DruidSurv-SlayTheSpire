package druidsurv.util;

import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.helpers.ModHelper;
import druidsurv.util.dailymods.Improvised;
import druidsurv.util.dailymods.QuincyStarter;

@SpirePatch(
        clz = AbstractCard.class,
        method = "moveToDiscardPile"
)
public class moveToDiscardPile {
    public static void Prefix() {
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised.ID) || ModHelper.isModEnabled(Improvised.ID)) {
            AbstractDungeon.player.discardPile.clear();
            AbstractDungeon.player.exhaustPile.clear();
        }
    }
    public static void Postfix() {
        if (CardCrawlGame.trial != null && CardCrawlGame.trial.dailyModIDs().contains(Improvised.ID) || ModHelper.isModEnabled(Improvised.ID)) {
            AbstractDungeon.player.discardPile.clear();
            AbstractDungeon.player.exhaustPile.clear();
        }
    }
}

