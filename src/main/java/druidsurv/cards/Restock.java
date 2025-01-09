package druidsurv.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.MakeTempCardInHandAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static druidsurv.CharacterFile.Enums.DRUIDSURV_COLOR;
import static druidsurv.ModFile.makeID;
import static druidsurv.util.Wiz.atb;

public class Restock extends AbstractEasyCard {
    public final static String ID = makeID("Restock");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Restock() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        magicNumber = 3;
        this.exhaust = true;
        setBackgroundTexture("druidsurvResources/images/512/power_skill.png", "druidsurvResources/images/1024/power_skill.png");
    }

    public void use(AbstractPlayer p, AbstractMonster m)
    {
        atb(new DrawCardAction(magicNumber));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}