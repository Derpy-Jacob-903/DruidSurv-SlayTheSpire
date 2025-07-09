package druidsurv.cards.colorless;

import basemod.AutoAdd;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.actions.unique.GamblingChipAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.CardStrings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import druidsurv.cards.AbstractEasyCard;

import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.makeInHand;

@AutoAdd.Ignore
public class DiscardX extends AbstractEasyCard {
    public final static String ID = makeID("DiscardX");
    private static final CardStrings cardStrings = CardCrawlGame.languagePack.getCardStrings("Normality");
    private static final int PLAY_LIMIT = 5;
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public DiscardX() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.NONE, CardColor.COLORLESS,"DiscardX");
        baseMagicNumber = magicNumber = PLAY_LIMIT;
        this.isInnate = true;
        this.isEthereal = true;
    }

    /*
    public boolean canPlay(AbstractCard card) {

        if (AbstractDungeon.actionManager.cardsPlayedThisTurn.size() >= PLAY_LIMIT) {
                 card.cantUseMessage = cardStrings.EXTENDED_DESCRIPTION[0];
                  return false;
                 }
             return true;
          }
    */

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        this.addToBot(new GamblingChipAction(AbstractDungeon.player, true));
    }

    public void onMoveToDiscard() {
        addToBot(new MakeTempCardInHandAction(makeCopy()));
    }

    public void triggerOnExhaust() {
        addToBot(new MakeTempCardInHandAction(makeCopy()));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(5);
    }
}